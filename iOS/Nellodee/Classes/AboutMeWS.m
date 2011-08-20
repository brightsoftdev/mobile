//
//  AboutMeWS.m
//  Nellodee
//
//  Created by Ada Hopper on 21/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "AboutMeWS.h"

#import "SBJson.h"
#import "NellodeeApp.h"
#import "About.h"

@implementation AboutMeWS


@synthesize responseData;
@synthesize aboutMe;

-(BOOL) meService{
	NellodeeApp *sharedNell = [NellodeeApp sharedNellodeeData];
	NSString *meServiceURL = [[sharedNell sakaiURL]	stringByAppendingString:@"/system/me"];
	NSLog(@"[ABOUT ME WS] Sakai url: %@",meServiceURL);
	
	
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
		NSLog(@"[ABOUT ME WS] Error: user no authenticated");
	}
	
	[[NSURLConnection alloc] initWithRequest:request delegate:self];  
	return YES;
	
} 




- (void)connection:(NSURLConnection *)connection didReceiveResponse:(NSURLResponse *)response {  
	NSLog(@"[ABOUT ME WS] Did ReceiveResponse");
	NSHTTPURLResponse *httpResponse = (NSHTTPURLResponse *)response;
	if ([httpResponse statusCode] >= 400) {
		NSLog(@"Remote url returned error %d %@",[httpResponse statusCode],[NSHTTPURLResponse localizedStringForStatusCode:[httpResponse statusCode]]);
	} else {
		NSLog(@"It is working. Status: %d %@",[httpResponse statusCode],[NSHTTPURLResponse localizedStringForStatusCode:[httpResponse statusCode]]);
		
	}
    [responseData setLength:0];  
}  

- (void)connection:(NSURLConnection *)connection didReceiveData:(NSData *)data {  
    
	NSLog(@"[ABOUT ME WS] Did receive data");    
	
	
	// Store incoming data into a string
	NSString *jsonString = [[NSString alloc] initWithData:data encoding:NSUTF8StringEncoding];
	
	// Create a dictionary from the JSON string
	NSDictionary *results = [jsonString JSONValue];
	//NSLog(@"Dictionary value for \"results\" is \"%@\"",results);
		
	
    NSDictionary * aboutMeDic = [[[results objectForKey:@"profile"] objectForKey:@"aboutme"] objectForKey:@"elements"];
    //NSLog(@"Dictionary value for \"about\" is \"%@\"",aboutMeDic);
	    
    aboutMe = [[About alloc]init];
    //NSLog(@"Dictionary value for \"aboutme\" is \"%@\"",[[aboutMeDic objectForKey:@"aboutme"] objectForKey:@"value"]);
	
    [aboutMe setAboutMe:[[aboutMeDic objectForKey:@"aboutme"] objectForKey:@"value"]];
    [aboutMe setAcademicInterests:[[aboutMeDic objectForKey:@"academicinterests"] objectForKey:@"value"]];
    [aboutMe setPersonalInterests:[[aboutMeDic objectForKey:@"personalinterests"] objectForKey:@"value"]];
    [aboutMe setHobbies:[[aboutMeDic objectForKey:@"hobbies"] objectForKey:@"value"]];
	
    //NellodeeApp *nell = [NellodeeApp sharedNellodeeData];
    //[nell setAboutMe:about];
	
	[[NellodeeApp sharedNellodeeData] setAboutMe:aboutMe];
	
	
	
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
    [aboutMe dealloc];
    [responseData dealloc];
    [super dealloc];
}

@end
