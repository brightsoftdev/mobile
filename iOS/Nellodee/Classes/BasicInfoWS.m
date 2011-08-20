//
//  BasicInfoWS.m
//  Nellodee
//
//  Created by Ada Hopper on 20/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "SBJson.h"
#import "NellodeeApp.h"
#import "BasicInfoWS.h"
#import "BasicInfo.h"

@implementation BasicInfoWS
@synthesize responseData;
@synthesize basicInfo;

-(BOOL) meService{
	NellodeeApp *sharedNell = [NellodeeApp sharedNellodeeData];
	NSString *meServiceURL = [[sharedNell sakaiURL]	stringByAppendingString:@"/system/me"];
	NSLog(@"[BASIC INFO WS] Sakai url: %@",meServiceURL);
	
	
	NSMutableURLRequest *request = [NSMutableURLRequest
									requestWithURL:[NSURL URLWithString:meServiceURL]];
	[request setHTTPMethod: @"GET"];
	[request setHTTPShouldHandleCookies:NO];
	[request addValue:meServiceURL forHTTPHeaderField:@"Referer"];
	NSArray* cookies = [[NSHTTPCookieStorage sharedHTTPCookieStorage]
						cookiesForURL:[NSURL URLWithString:[sharedNell sakaiURL]]];
	NSDictionary* headers = [NSHTTPCookie requestHeaderFieldsWithCookies:cookies];
	
	if(cookies != nil){
		[request setAllHTTPHeaderFields:headers];
	}
	else{
		NSLog(@"[BASIC INFO WS] Error: user no authenticated");
	}
	
	[[NSURLConnection alloc] initWithRequest:request delegate:self];  
	return YES;
	
} 




- (void)connection:(NSURLConnection *)connection didReceiveResponse:(NSURLResponse *)response {  
	NSLog(@"[BASIC INFO WS] Did ReceiveResponse");
	NSHTTPURLResponse *httpResponse = (NSHTTPURLResponse *)response;
	if ([httpResponse statusCode] >= 400) {
		NSLog(@"Remote url returned error %d %@",[httpResponse statusCode],[NSHTTPURLResponse localizedStringForStatusCode:[httpResponse statusCode]]);
	} else {
		NSLog(@"It is working. Status: %d %@",[httpResponse statusCode],[NSHTTPURLResponse localizedStringForStatusCode:[httpResponse statusCode]]);
		
	}
    [responseData setLength:0];  
}  

- (void)connection:(NSURLConnection *)connection didReceiveData:(NSData *)data {  
    basicInfo = [[BasicInfo alloc]init];
    
	NSLog(@"didReceiveData");    
	
	
	// Store incoming data into a string
	NSString *jsonString = [[NSString alloc] initWithData:data encoding:NSUTF8StringEncoding];
	
	// Create a dictionary from the JSON string
	NSDictionary *results = [jsonString JSONValue];
	//NSLog(@"Dictionary value for \"results\" is \"%@\"",results);
	
	NSString *username = [[NSString alloc] initWithString:[[results objectForKey:@"user"] objectForKey:@"userid"]];
	[basicInfo setUsername:username];
	 
	NSDictionary * properties = [[results objectForKey:@"user"] objectForKey:@"properties"];
	//NSLog(@"Dictionary value for \"foo\" is \"%@\"",properties);
	 

	//Getting the profile picture
	SBJsonParser * jsonParser = [SBJsonParser new];
	NSDictionary * picPath = [jsonParser objectWithString:[properties objectForKey:@"picture"]];
	if(picPath!=nil){
		NSString *pathPicture = [[NSString alloc] initWithString:[@"/~" stringByAppendingString:username]];
		pathPicture = [pathPicture stringByAppendingString:[@"/public/profile/" stringByAppendingString:[picPath objectForKey:@"name"]]];

		[basicInfo setPicturePath:[pathPicture copy]];
		[pathPicture release];
	}
	[picPath release];
	[jsonParser release];

	
	[basicInfo setFirstName:[properties objectForKey:@"firstName"]];
	[basicInfo setLastName:[properties objectForKey:@"lastName"]];
	[basicInfo setPrefName:[properties objectForKey:@"preferredName"]];
	[basicInfo setEmail:[properties objectForKey:@"email"]];
	[basicInfo setRol:[properties objectForKey:@"role"]];
	[basicInfo setDepartament:[properties objectForKey:@"department"]];
	[basicInfo setCollege:[properties objectForKey:@"college"]];
	
	//Separating user tags from categories
	NSString *tagsString = [properties objectForKey:@"sakai:tags"];
	NSArray *tagsArray = [tagsString componentsSeparatedByString:@","];
	for(NSString *tag in tagsArray){
		if(![tag hasPrefix:@"directory/"]){
			[basicInfo setTags:tag];
			break;
		}
	}
	
	[[NellodeeApp sharedNellodeeData] setBasicInfo:basicInfo];
	 

	
}  

- (void)connection:(NSURLConnection *)connection didFailWithError:(NSError *)error {  
	NSLog(@"Connection failed: %@", [error description]);
}  

- (void)connectionDidFinishLoading:(NSURLConnection *)connection {  
	NSLog(@"connectionDidFinishLoading");
    [[NSNotificationCenter defaultCenter] postNotificationName:@"meServiceNotification" object:self];
	
	
    [connection release];  
    [responseData release];  
	
}  


- (void)dealloc {
    [basicInfo dealloc];
    [responseData dealloc];
    [super dealloc];
}



@end
