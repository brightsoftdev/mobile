//
//  CategoriesWS.m
//  Nellodee
//
//  Created by Ada Hopper on 21/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "CategoriesWS.h"

#import "SBJson.h"
#import "NellodeeApp.h"

@implementation CategoriesWS
@synthesize responseData;
@synthesize categoriesTags;

-(BOOL) meService{
	NellodeeApp *sharedNell = [NellodeeApp sharedNellodeeData];
	NSString *meServiceURL = [[sharedNell sakaiURL]	stringByAppendingString:@"/system/me"];
	NSLog(@"[CATEGORIES WS] Sakai url: %@",meServiceURL);
	
	
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
		NSLog(@"[CATEGORIES WS] Error: user no authenticated");
	}
	
	[[NSURLConnection alloc] initWithRequest:request delegate:self];  
	return YES;
	
} 




- (void)connection:(NSURLConnection *)connection didReceiveResponse:(NSURLResponse *)response {  
	NSLog(@"[CATEGORIES WS] Did ReceiveResponse");
	NSHTTPURLResponse *httpResponse = (NSHTTPURLResponse *)response;
	if ([httpResponse statusCode] >= 400) {
		NSLog(@"Remote url returned error %d %@",[httpResponse statusCode],[NSHTTPURLResponse localizedStringForStatusCode:[httpResponse statusCode]]);
	} else {
		NSLog(@"It is working. Status: %d %@",[httpResponse statusCode],[NSHTTPURLResponse localizedStringForStatusCode:[httpResponse statusCode]]);
		
	}
    [responseData setLength:0];  
}  

- (void)connection:(NSURLConnection *)connection didReceiveData:(NSData *)data {  
	categoriesTags =[[NSMutableArray alloc] init];    
	NSLog(@"[CATEGORIES WS] Did receive data");    
	
	
	// Store incoming data into a string
	NSString *jsonString = [[NSString alloc] initWithData:data encoding:NSUTF8StringEncoding];
	
	// Create a dictionary from the JSON string
	NSDictionary *results = [jsonString JSONValue];
	//NSLog(@"Dictionary value for \"results\" is \"%@\"",results);
		
	NSDictionary * properties = [[results objectForKey:@"user"] objectForKey:@"properties"];
	//NSLog(@"Dictionary value for \"foo\" is \"%@\"",properties);
	
	//Getting the categories tags
	NSString *tagsString = [properties objectForKey:@"sakai:tags"];
	NSArray *tagsArray = [tagsString componentsSeparatedByString:@","];
	for(NSString *tag in tagsArray){
		if([tag hasPrefix:@"directory/"]){
			[categoriesTags addObject:tag];
		}
	}
	
	//Store the data
	NellodeeApp *nell = [NellodeeApp sharedNellodeeData];
	Profile *userProfile = [nell userProfile];
	[userProfile setCategories:categoriesTags];
	[nell setUserProfile:userProfile];

	
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
    [categoriesTags dealloc];
    [responseData dealloc];
    [super dealloc];
}



@end
