//
//  User.m
//  Nellodee
//
//  Created by Ada Hopper on 11/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "User.h"


@implementation User

@synthesize responseData;

-(BOOL) meService{
	NSLog(@" ---- me Service ---");
	NSMutableURLRequest *request = [NSMutableURLRequest
									requestWithURL:[NSURL URLWithString:@"http://10.211.55.2:8080/system/me"]];
	
	NSArray* cookies = [[NSHTTPCookieStorage sharedHTTPCookieStorage]
						cookiesForURL:[NSURL URLWithString:@"http://10.211.55.2:8080"]];
	NSDictionary* headers = [NSHTTPCookie requestHeaderFieldsWithCookies:cookies];

					
	[request setHTTPMethod: @"GET"];
	[request setHTTPShouldHandleCookies:NO];
	[request addValue:@"http://10.211.55.2:8080/system/me" forHTTPHeaderField:@"Referer"];
	[request setAllHTTPHeaderFields:headers];
	
		
	[[NSURLConnection alloc] initWithRequest:request delegate:self startImmediately:YES];  
	
	NSURLConnection *connection = [[NSURLConnection alloc] 
								   initWithRequest:request delegate:self];
} 

- (void)connection:(NSURLConnection *)connection didReceiveResponse:(NSURLResponse *)response {  
	NSLog(@"didReceiveResponse");
	NSHTTPURLResponse *httpResponse = (NSHTTPURLResponse *)response;
	if ([httpResponse statusCode] >= 400) {
		NSLog(@"Remote url returned error %d %@",[httpResponse statusCode],[NSHTTPURLResponse localizedStringForStatusCode:[httpResponse statusCode]]);
	} else {
		NSLog(@"It is working. Status: %d %@",[httpResponse statusCode],[NSHTTPURLResponse localizedStringForStatusCode:[httpResponse statusCode]]);
	}
    [responseData setLength:0];  
}  

- (void)connection:(NSURLConnection *)connection didReceiveData:(NSData *)data {  
	NSLog(@"didReceiveData");
	
    [responseData appendData:data];  
}  

- (void)connection:(NSURLConnection *)connection didFailWithError:(NSError *)error {  
	NSLog(@"Connection failed: %@", [error description]);
}  

- (void)connectionDidFinishLoading:(NSURLConnection *)connection {  
	NSLog(@"connectionDidFinishLoading");
	
	
	
    [connection release];  
    [responseData release];  
	
}  


@end
